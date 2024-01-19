package base

import androidx.paging.PagingSource
import entity.Entity
import models.AuthException
import models.NetworkException
import models.NoNetworkException
import models.ResponseStatus
import retrofit2.HttpException
import retrofit2.Response
import java.net.UnknownHostException

abstract class BasePagingDataSource<T : Any>(
    private val pagination: String = TAG,
) : PagingSource<Int, T>() {
    protected suspend fun <K : Any> safeApiSuspendResult(call: suspend () -> Response<K>?): ResponseStatus<K> {
        val response: Response<K>?
        return try {
            response = call.invoke()
            when (response?.code()) {
                in ResponseCodes.SUCCESS_CODES -> {
                    if(response?.isSuccessful == true){
                        ResponseStatus.Success(
                            data = response.body(),
                            code = response.code()
                        )
                    }else{
                        ResponseStatus.Error(
                            exception = NetworkException(
                                message = response?.message(),
                                cause = Throwable(pagination)
                            )
                        )
                    }

                }
                in ResponseCodes.SERVER_ERROR_CODE -> {
                    ResponseStatus.Error(
                        NetworkException(
                            response?.message(),
                            Throwable(pagination),
                        )
                    )
                }
                else -> {
                    ResponseStatus.Error(
                        NetworkException(
                            response?.message(),
                            Throwable(pagination),
                        )
                    )
                }
            }
        } catch (e: Exception) {
            when (e) {
                is UnknownHostException -> {
                    ResponseStatus.Error(
                        NoNetworkException(
                            e.message,
                            Throwable(pagination),
                        )
                    )
                }
                is HttpException -> {
                    if (e.code() == 401) {
                        ResponseStatus.Error(
                            AuthException(
                                "Время сессии истекло",
                                Throwable(pagination),
                            )
                        )
                    } else {
                        ResponseStatus.Error(
                            NetworkException(
                                e.message,
                                Throwable(pagination),
                            )
                        )
                    }

                }
                else -> {
                    ResponseStatus.Error(
                        NetworkException(
                            e.message,
                            Throwable(pagination),
                        )
                    )
                }
            }
        }
    }

    protected fun <Key : Any, G : Any> map(
        nextPageNumber: Key?,
        prevPageNumber: Key?,
        call: () -> List<G>
    ): LoadResult<Key, G> {
        return try {
            LoadResult.Page(
                call.invoke(),
                prevPageNumber,
                nextPageNumber,
            )

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    protected fun <G : Any> map(call: () -> G): Entity<G> {
        return try {
            Entity.Success(
                call.invoke()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Entity.Error("Произошла ошибка")
        }
    }

    companion object {
        private const val TAG = "Pagination"
        const val LIMIT = 10
        const val PAGE = 1
    }

}
