package com.example.githubapp.ui.issue;

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
public final class IssueViewModel_Factory implements Factory<IssueViewModel> {
  private final Provider<GithubRepository> githubRepositoryProvider;

  private final Provider<NetworkUtils> networkUtilsProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public IssueViewModel_Factory(Provider<GithubRepository> githubRepositoryProvider,
      Provider<NetworkUtils> networkUtilsProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.githubRepositoryProvider = githubRepositoryProvider;
    this.networkUtilsProvider = networkUtilsProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public IssueViewModel get() {
    return newInstance(githubRepositoryProvider.get(), networkUtilsProvider.get(), savedStateHandleProvider.get());
  }

  public static IssueViewModel_Factory create(Provider<GithubRepository> githubRepositoryProvider,
      Provider<NetworkUtils> networkUtilsProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new IssueViewModel_Factory(githubRepositoryProvider, networkUtilsProvider, savedStateHandleProvider);
  }

  public static IssueViewModel newInstance(GithubRepository githubRepository,
      NetworkUtils networkUtils, SavedStateHandle savedStateHandle) {
    return new IssueViewModel(githubRepository, networkUtils, savedStateHandle);
  }
}
