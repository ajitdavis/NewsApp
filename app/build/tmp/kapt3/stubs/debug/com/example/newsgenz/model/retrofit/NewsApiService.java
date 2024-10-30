package com.example.newsgenz.model.retrofit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\t\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/newsgenz/model/retrofit/NewsApiService;", "", "getEveryNews", "Lretrofit2/Response;", "error/NonExistentClass", "country", "", "pageNumber", "", "key", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopHeadline", "category", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface NewsApiService {
    
    @retrofit2.http.GET(value = "v2/top-headlines")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getEveryNews(@retrofit2.http.Query(value = "country")
    @org.jetbrains.annotations.NotNull
    java.lang.String country, @retrofit2.http.Query(value = "page")
    int pageNumber, @retrofit2.http.Query(value = "apiKey")
    @org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "v2/top-headlines")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTopHeadline(@retrofit2.http.Query(value = "country")
    @org.jetbrains.annotations.NotNull
    java.lang.String country, @retrofit2.http.Query(value = "category")
    @org.jetbrains.annotations.NotNull
    java.lang.String category, @retrofit2.http.Query(value = "apiKey")
    @org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}