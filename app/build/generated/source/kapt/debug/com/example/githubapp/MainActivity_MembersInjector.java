package com.example.githubapp;

import com.example.githubapp.util.NetworkConnectivityMonitor;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<NetworkConnectivityMonitor> networkConnectivityMonitorProvider;

  public MainActivity_MembersInjector(
      Provider<NetworkConnectivityMonitor> networkConnectivityMonitorProvider) {
    this.networkConnectivityMonitorProvider = networkConnectivityMonitorProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<NetworkConnectivityMonitor> networkConnectivityMonitorProvider) {
    return new MainActivity_MembersInjector(networkConnectivityMonitorProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectNetworkConnectivityMonitor(instance, networkConnectivityMonitorProvider.get());
  }

  @InjectedFieldSignature("com.example.githubapp.MainActivity.networkConnectivityMonitor")
  public static void injectNetworkConnectivityMonitor(MainActivity instance,
      NetworkConnectivityMonitor networkConnectivityMonitor) {
    instance.networkConnectivityMonitor = networkConnectivityMonitor;
  }
}
