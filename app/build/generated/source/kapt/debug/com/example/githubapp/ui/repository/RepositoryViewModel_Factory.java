package com.example.githubapp.ui.repository;

import androidx.lifecycle.SavedStateHandle;
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
public final class RepositoryViewModel_Factory implements Factory<RepositoryViewModel> {
  private final Provider<GithubRepository> githubRepositoryProvider;

  private final Provider<NetworkUtils> networkUtilsProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public RepositoryViewModel_Factory(Provider<GithubRepository> githubRepositoryProvider,
      Provider<NetworkUtils> networkUtilsProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.githubRepositoryProvider = githubRepositoryProvider;
    this.networkUtilsProvider = networkUtilsProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public RepositoryViewModel get() {
    return newInstance(githubRepositoryProvider.get(), networkUtilsProvider.get(), savedStateHandleProvider.get());
  }

  public static RepositoryViewModel_Factory create(
      Provider<GithubRepository> githubRepositoryProvider,
      Provider<NetworkUtils> networkUtilsProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new RepositoryViewModel_Factory(githubRepositoryProvider, networkUtilsProvider, savedStateHandleProvider);
  }

  public static RepositoryViewModel newInstance(GithubRepository githubRepository,
      NetworkUtils networkUtils, SavedStateHandle savedStateHandle) {
    return new RepositoryViewModel(githubRepository, networkUtils, savedStateHandle);
  }
}
