package event

import account.RESTfulUserManager
import post.Post
import views.presentation.PostButtons

sealed interface TrendWaveEvent {

    /**
     * Button Clicks
     */
    object ClickClosePostButton: TrendWaveEvent
    object ClickCloseSettingsScreen: TrendWaveEvent
    object ClickCloseProfileScreen: TrendWaveEvent
    object ClickForgotPasswordSheet: TrendWaveEvent
    object ClickCloseForgotPasswordSheet: TrendWaveEvent
    object ClickPostButton: TrendWaveEvent
    object ClickSettingsScreen: TrendWaveEvent
    object ClickProfileHomeButton: TrendWaveEvent
    class ClickUserProfileViewButton(val user: RESTfulUserManager.User): TrendWaveEvent




    /**
     * Events
     */
    object ApplicationStartEvent: TrendWaveEvent

    class FollowEvent(val follow: Boolean, val executeruuid: String, val uuid: String): TrendWaveEvent
    class loadDataToCachePostButtons(val buttons: List<PostButtons>): TrendWaveEvent




    class ChangeLoginErrorMessage(val message: String): TrendWaveEvent
    class ChangeRegisterErrorMessage(val message: String): TrendWaveEvent
    class ChangePostErrorMessage(val message: String): TrendWaveEvent
    class UpdatePostList(val posts: List<Post>): TrendWaveEvent
    class PostDeletionButton(val post: Post, val posts: List<Post>): TrendWaveEvent
    class LocalPostCreation(val post: Post): TrendWaveEvent
    object TestHomeButton: TrendWaveEvent
    object FollowingHomeButton: TrendWaveEvent
}