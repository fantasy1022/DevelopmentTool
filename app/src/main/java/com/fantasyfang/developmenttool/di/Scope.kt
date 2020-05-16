package com.fantasyfang.developmenttool.di

import javax.inject.Scope

@Scope
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope


@Scope
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention
annotation class FragmentScope