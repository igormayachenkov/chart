package ru.igormayachenkov.chart.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.igormayachenkov.chart.data.DataListRepo
import ru.igormayachenkov.chart.data.DataListRepoMock
import ru.igormayachenkov.geo.feature.split.SplitStateSaver
import ru.igormayachenkov.geo.feature.split.SplitStateSaverImpl
import javax.inject.Singleton

// BIND REPO INTERFACES TO IMPLEMENTATIONS
@Module
@InstallIn(SingletonComponent::class)
abstract class RepoBindingModule {
    @Singleton
    @Binds
    abstract fun bindSplitStateSaver (impl: SplitStateSaverImpl) : SplitStateSaver

    @Singleton
    @Binds
    abstract fun bindDataListRepo (impl: DataListRepoMock) : DataListRepo
}