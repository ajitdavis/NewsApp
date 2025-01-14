package com.example.newsgenz.model.retrofit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/newsgenz/model/retrofit/RetrofitProvider;", "", "()V", "baseUrl", "", "getNewsApiService", "Lcom/example/newsgenz/model/retrofit/NewsApiService;", "getRetrofitInstance", "Lretrofit2/Retrofit;", "app_debug"})
public final class RetrofitProvider {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String baseUrl = "https://newsapi.org/";
    @org.jetbrains.annotations.NotNull
    public static final com.example.newsgenz.model.retrofit.RetrofitProvider INSTANCE = null;
    
    private RetrofitProvider() {
        super();
    }
    
    private final retrofit2.Retrofit getRetrofitInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.newsgenz.model.retrofit.NewsApiService getNewsApiService() {
        return null;
    }
}