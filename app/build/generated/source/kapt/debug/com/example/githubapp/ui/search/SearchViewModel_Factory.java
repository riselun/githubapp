package com.example.githubapp.ui.search;

import com.example.githubapp.data.repository.GithubRepository;
import com.example.githubapp.util.NetworkUtils;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<GithubRepository> githubRepositoryProvider;

  private final Provider<NetworkUtils> networkUtilsProvider;

  public SearchViewModel_Factory(Provider<GithubRepository> githubRepositoryProvider,
      Provider<NetworkUtils> networkUtilsProvider) {
    this.githubRepositoryProvider = githubRepositoryProvider;
    this.networkUtilsProvider = networkUtilsProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(githubRepositoryProvider.get(), networkUtilsProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<GithubRepository> githubRepositoryProvider,
      Provider<NetworkUtils> networkUtilsProvider) {
    return new SearchViewModel_Factory(githubRepositoryProvider, networkUtilsProvider);
  }

  public static SearchViewModel newInstance(GithubRepository githubRepository,
      NetworkUtils networkUtils) {
    return new SearchViewModel(githubRepository, networkUtils);
  }
}
