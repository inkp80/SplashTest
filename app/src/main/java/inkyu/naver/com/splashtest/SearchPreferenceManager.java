package inkyu.naver.com.splashtest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

public class SearchPreferenceManager {
    private static SearchPreferenceManager mSelfInstance = null;

    public final static String PREFERENCE_KEY = "null";

    public final static String PREF_KEY_FIRST_RUN = "keyFirstRun";
    //Selected tab index of the shortcut page
    public final static String PREF_KEY_SELECTED_SHORTCUT_TAB = "keyShortcutTabIndex";

    /**
     * 위치 정보 사용 동의 여부
     */
    public final static String PREF_KEY_LOCATION_BASED_SEARCH_ENABLED = "keyLocationAgree";
    public final static String PREF_KEY_LOCATION_USER_AGREEMENT_ACCEPTED = "keyLocationUserAgreementAccepted";
    /**
     * 위치 정보 사용 동의를 했는지 여부
     */
    public final static String PREF_KEY_LOCATION_AGREE_SET_CHECK = "keyLocationAgreeSetCheck";
    public final static String PREF_KEY_INITIAL_VIEW = "keyInitialView";
    public final static String PREF_KEY_RECENT_VIEW = "keyRecentView";
    public final static String PREF_KEY_SEARCH_ADDRESS_BOOK = "keySearchAddressBook";
    public final static String PREF_KEY_NOTI_APP_UPDATE = "keyNotiAppUpdate";
    public final static String PREF_KEY_RECORD_HISTORY = "keyRecordHistory";
    public final static String PREF_KEY_USE_SEARCH_AUTOCOMPLETE = "keyUseSearchAutoComplete";
    public final static String PREF_KEY_SERVICE_LINK_NCLICKS = "serviceNClicks";

    public final static String PREF_KEY_SHOOTUP_DATE_NEXEARCH = "shootUpNexeachDate";
    public final static String PREF_KEY_SHOOTUP_DATE_NEWS = "shootUpNewsDate";
    public final static String PREF_KEY_SHOOTUP_DATE_MOVIE = "shootUpMovieDate";

    public final static String PREF_KEY_SERVICE_LINK_INFO_UPDATE_TIME = "serviceLinkUpdateTime";
    public final static String PREF_KEY_INSTALLED_WIDGET = "installedWidget";

    public final static String PREF_KEY_INSTALLED_WIDGET_INCREMENTAL = "installedWidgetIncremental";
    public final static String PREF_KEY_INSTALLED_WIDGET_RELEASE = "installedWidgetRelease";
    public final static String PREF_KEY_INSTALLED_WIDGET_SDK_VER = "installedWidgetSdkVer";

    public final static String PREF_KEY_INSTALLED_WIDGET_CHECK = "installedWidgetCheck";

    public final static String PREF_KEY_LAST_SEARCH_LOCATION_LATITUDE = "lastLocationLatitude";
    public final static String PREF_KEY_LAST_SEARCH_LOCATION_LONGITITUDE = "lastLocationLongtitude";
    public final static String PREF_KEY_LAST_SEARCH_LOCATION_TIME = "lastLocationTime";
    public final static String PREF_KEY_LAST_SEARCH_LOCATION_ACCURACY = "lastLocationAccuracy";

    // 이벤트 팝업 캐싱
    public final static String PREF_KEY_LAST_EVENTPOPUP_TITLE = "lastEventPopupTitle";
    public final static String PREF_KEY_LAST_EVENTPOPUP_CONTENT = "lastEventPopupContent";
    public final static String PREF_KEY_LAST_EVENTPOPUP_LINKURL = "lastEventPopupLinkURL";
    public final static String PREF_KEY_LAST_EVENTPOPUP_SEQ = "lastEventPopupSeq";
    public final static String PREF_KEY_LAST_SHOWN_EVENTPOPUP_SEQ = "lastShownEventPopupSeq";

    private static final String INVALID_SEARCH_LOCATION = "Invalid";

    public final static String PREF_KEY_SEARCH_HISTORY = "keySearchHistory"; // 검색 히스토리 사용 여부

    // OCR 검색 맨 처음 실행시 가이드 화면 띄우는 것 관련 플러그
    public final static String PREF_KEY_GREEN_WINDOW_SEARCH_FIRST_EXECUTE_CHECK = "keyGreenSearchFirsyExecuteCheck";
    public final static String PREF_KEY_JAPANESE_SEARCH_FIRST_EXECUTE_CHECK = "keyJapaneseSearchFirsyExecuteCheck";
    public final static String PREF_KEY_CODE_FIRST_EXECUTE_CHECK = "keyCodeFirsyExecuteCheck";

    //Running counts of recognition panel
    public final static String PREF_KEY_HOME_BUTTON_PANEL_COUNT_CHECK = "keyRecogintionHomeRunningCountCheck10";

    //Show shortcut edit guide
    public final static String PREF_KEY_SHOW_SHORTCUT_GUIDE = "keyShortcutGuide";
    public final static String PREF_KEY_SHOW_SHORTCUT_REMOVE_GUIDE = "keyShortcutRemoveGuide";

    // 그린닷 바로가기 3개 미만의 사용자가 업데이트 이후에 그린닷 최초 접근 시 AIRS 추천을 권유하기 위한 플래그
    public final static String PREF_KEY_FIRST_ENTER_AFTER_UPDATE_AIRS_RECOMMEND = "keyShortcutFirstAiRSRecommend";

    public final static String PREF_KEY_GREENDOT_VERSION = "keyGreenDotVersion";

    // 그린닷 바로가기가 편집 화면(웹)을 통해서 전체 삭제된 이후 AIRS 추천을 권유하기 위한 플래그
    public final static String PREF_KEY_SHORTCUTS_EMPTIED_FROM_WEB_AIRS_RECOMMEND = "keyShortcutsEmptiedByWeb";

    //Show url input guide
    public final static String PREF_KEY_SHOW_URLINPUT_GUIDE = "keyUrlInputGuide";

    public final static String PREF_KEY_URLINPUT_USED_CLIP_URL = "keyUrlInputUsedClipURL";
    public final static String PREF_KEY_URLINPUT_USED_CLIP_URL_FROM_NOTI_NUDGE = "keyUrlInputUsedClipURLFromNotiNudge";

    public final static String PREF_KEY_MUSIC_EVENT_HIDDEN_TIME = "keyMusicEveentPopupHiddenTime";
    public final static String PREF_KEY_MUSIC_EVENT_HIDDEN_TIME_COMPLETE = "keyMusicEveentPopupHiddenCompleteTime";

    // 앱이 활성화 되어있는지 여부를 체크할 때 사용된다.
    public final static String PREF_KEY_ACTIVE_APP_CHECK = "keyActiveAppCheck";
    public final static String PREF_KEY_ACTIVE_APP_START_TIME = "keyActiveAppStartTime";
    public final static String PREF_KEY_ACTIVE_APP_END_TIME = "keyActiveAppEndTime";

    // 앱 재실행 시 네이버앱 홈으로 시작 여부 체크.(12시간후)
    public final static String PREF_KEY_CHECK_RESTART_HOME = "keyCheckRestartHome";

    // 빠른검색창(알림창 검색) 사용유무
    public final static String PREF_KEY_CHECK_NOTI_SEARCHBAR = "keySettingNotiSearchBar";
    public final static String PREF_KEY_CHECK_WINDOW_POPUP_BLOCK = "windowPopupBlock";

    /**
     * 북마크v2 자주가는 사이트 마이그레이션 flag
     */
    public final static String PREF_KEY_FAVORITESITE_MIGRATED_USER = "keyFavoriteSiteMigratedUser";

    /**
     * 로그인 쿠키 암호화 해서 저장
     */
    public final static String PREF_KEY_LOGIN_COOKIE = "keyLoginCookie";

    /**
     * 로그인 쿠키 생성 시간
     */
    public final static String PREF_KEY_LOGIN_COOKIE_CREATE_TIME = "keyLoginCookieCreateTime";

    /**
     * 로그인 아이디 저장
     */
    public final static String PREF_KEY_LOGIN_NAVER_ID = "keyLoginNaverId";

    /**
     * 로그인 아이디 저장
     */
    public final static String PREF_KEY_LOGIN_ME2DAY_ID = "keyLoginMe2dayId";

    /**
     * 위젯에서 로그인을 했는지 여부
     */
    public final static String PREF_KEY_LOGIN_WIDGET_CHECK = "keyLoginWidgetCheck";

    /**
     * 빠른 실행 아이콘 만들기 관련
     */
    public final static String PREF_KEY_SHOUTCUT_INSTALL2 = "keyShoutcutInstalled2";

    /**
     * 알람 기능 아웃 가이드 팝업 노출 날짜
     */
    public final static String PREF_KEY_ALARM_OUT_GUIDE_SHOWN_DATE = "keyAlarmOutGuideShownDate";

    /**
     * 웹뷰 설정
     */
    public final static String PREF_KEY_SHOW_WEBVIEW_TOOLBAR = "keyShowWebViewToolBar";

    /*
     * ?캐시 삭제 시간*/
    public final static String LAST_APPCACHE_CLEAR = "keyLastAppCacheClear";

    /**
     * 인식검색 사진 갤러리 저장
     */
    public final static String PREF_KEY_SAVE_RECOGNITINO = "keySaveRecognitino";
    public final static boolean DEFAULT_VALUE_SAVE_RECOGNITINO = false;

    /**
     * 검색창 확장에서 사용
     */
    public final static String PREF_KEY_SEARCH_EXTEND_LOCATION_LATITUDE = "searchExtendLocationLatitude";
    public final static String PREF_KEY_SEARCH_EXTEND_LOCATION_LONGITITUDE = "searchExtendLocationLongtitude";
    public final static String PREF_KEY_SEARCH_EXTEND_LOCATION_ADDRESS = "searchExtendLocationAddress";
    public final static String PREF_KEY_USE_SEARCH_EXTEND_LOCATION = "useSearchExtendLocationLongtitude";

    /**
     * 푸쉬 관련 설정
     */
    public final static String PREF_KEY_USE_PUSH_NOTI = "keyUsePushNoti"; // 푸쉬 알림을 사용하는지 여부
    public final static boolean DEFAULT_USE_PUSH_NOTI = true; // 푸쉬 알림 기본 사용 값 설정
    public final static String PREF_KEY_PUSH_NOTI_DEVICE_TOKEN = "keyPushNotiDeviceToken"; // 푸쉬 알림을 하기 위한 디바이스 토큰 저장
    public final static String PREF_KEY_PUSH_NOTI_UUID = "keyPushNotiUUID"; // 푸쉬 알림을 하기 위한 UUID 저장
    public final static String PREF_KEY_PUSH_NOTI_PLATFORM = "keyPushNotiPlatform"; // 가장 최근에 접속한 푸쉬 알림 플랫폼 EX) NNI, C2DM 등

    //	public final static String PREF_KEY_PUSH_NOTI_PLATFORM_PRIORITY_CREATE_TIME = "keyPushNotiPlatformPriorityCreateTime"; // 푸쉬 알림 플랫폼 후보 얻은 시간
    public final static String PREF_KEY_PUSH_REGISTER_VERSION_CODE = "keyPushRegisterVersionCode"; // 푸쉬 등록 버전 코드 정보
    public final static String PREF_KEY_PUSH_FORCE_INITIAL_CONFIG = "keyPushForceInitial";
    public final static String PREF_KEY_PUSH_NOTI_DEVICE_TOKEN_TIME = "keyPushNotiDeviceTokenTime"; // 푸쉬 알림을 하기 위한 디바이스 토큰 저장 시간

    // 푸쉬 기타 설정 관련
    public final static String PREF_KEY_USE_PUSH_NOTI_POPUP_VIEW = "keyUsePushNotiPopupView"; // 푸쉬 알림 팝업 보기
    public final static boolean DEFAULT_PUSH_NOTI_POPUP_VIEW = false; // 푸쉬 알림 팝업 보기
    public final static String PREF_KEY_USE_PUSH_NOTI_SOUND_SET = "keyUsePushNotiPopupSet"; // 푸쉬 무음 모드
    public final static boolean DEFAULT_PUSH_NOTI_SOUND_SET = false; // 푸쉬 알림 모음 모드

    public final static String PREF_KEY_CHECK_SHOW_PUSH_NOTI_GUIDE_POPUP = "keyCheckShowPushNotiGuidePopup"; // 푸쉬 알림 가이드 팝업 봤는지 여부

    /**
     * 북마크 연동
     */
    public final static String PREF_KEY_BOOKMARK_PREV_ID = "keyUseBookmarkPrevId"; // 북마크 연동했는지 여부
    public final static String PREF_KEY_BOOKMARK_UPDATE_DATE = "keyUseBookmarkUpdateDate"; // 북마크 업데이트 시간
    public final static String PREF_KEY_BOOKMARK_CHANGE_QUICK_FIRST = "keyUseBookmarkChangeQuickFirst"; // 북마크 자주가는사이트 첫 변경
    public final static String PREF_KEY_BOOKMARK_SYNC_ID = "keyUseBookmarkSyncId"; // 북마크 연동한 아이디
    public final static String PREF_KEY_BOOKMARK_MORE_ITEM_NUM = "keyUseBookmarkMoreItemNum"; // 북마크 더보기 남은 항목 기억
    public final static String PREF_KEY_BOOKMARK_PAGE_NUM = "keyUseBookmarkPageNum"; // 북마크 현재 페이지 기억
    public final static String PREF_KEY_BOOKMARK_SYNCED = "keyUseBookmarkSynced"; // 북마크 현재 페이지 기억

    /**
     * 다운로드 센터 관리
     */
    public final static String PREF_KEY_FIRST_INSTALL_DATE = "keyFirstInstallDate"; // 최초로 네이버앱이 설치된 날짜 (3.3.0 이후)
    public final static String PREF_KEY_NOMORE_FIRST_INSTALLED = "keyNoMoreFirstInstalled";
    public final static String PREF_KEY_NEW_CONTENTS_NOTI = "keyNotiNewContents_%s";
    public final static String PREF_KEY_NEW_CONTENTS_NOTI_UNIQUE = "keyNotiNewContents_uniqueid";

    /**
     * 지식인
     */
    public final static String PREF_KEY_KIN_PUBLIC_ID = "keyKinPublicId";
    public final static String PREF_KEY_KIN_UNDER_14 = "keyKinUnder14";
    public final static String PREF_KEY_KIN_AUDIO_FIRST = "keyKinAudioFirst";
    public final static String PREF_KEY_KIN_LAST_TAB = "keyKinLastTab";

    public final static int INITIAL_VIEW_SHOOT_UP = 0;
    public final static int INITIAL_VIEW_SERVICE_LINK = 1;

    public static final boolean DEFAULT_LOCATION_BASED_SEARCH_DISABLE = false;
    private static final int DEFAULT_INITIAL_VIEW = INITIAL_VIEW_SERVICE_LINK;
    private static final int DEFAULT_RECENT_VIEW = DEFAULT_INITIAL_VIEW;
    private static final boolean DEFAULT_SEARCH_ADDRESS_BOOK = true;
    public static final boolean DEFAULT_NOTI_APP_UPDATE = true;
    public static final boolean DEFAULT_RECORD_HISTORY = true;
    private static final boolean DEFAULT_USE_SEARCH_AUTOCOMPLETE = true;
    private static final boolean DEFAULT_INSTALL_WIDGET = false;
    public static final boolean DEFAULT_RESTART_HOME = true;
    public static final boolean DEFAULT_QUICK_SEARCH_SETTING = false;
    private static final boolean DEFAULT_WINDOW_POPUP_BLOCK = true;
    //	private static final String DEFAULT_INSTALL_WIDGET_INCREMENTAL = "0";
    //	private static final String DEFAULT_INSTALL_WIDGET_RELEASE = "0";
    //	private static final int DEFAULT_INSTALL_WIDGET_SDK_VER = 0;

    private static final String DEFAULT_SERVICE_LINK_NCLICKS_AREA_CODE = "";

    private SharedPreferences mPreference = null;
    private boolean mIsLocationBasedSearchEnabled = DEFAULT_LOCATION_BASED_SEARCH_DISABLE;
    private int mInitilView = DEFAULT_INITIAL_VIEW;
    private int mRecentView = DEFAULT_RECENT_VIEW;
    private boolean mSearchIncludeAddressBook = DEFAULT_SEARCH_ADDRESS_BOOK;
    private boolean mNotiAppUpdate = DEFAULT_NOTI_APP_UPDATE;
    private boolean mRecordHistory = DEFAULT_RECORD_HISTORY;
    private boolean mUseSearchAutoComplete = DEFAULT_USE_SEARCH_AUTOCOMPLETE;
    private String mServiceLinkNClicksAreaCode = DEFAULT_SERVICE_LINK_NCLICKS_AREA_CODE;
    private boolean mInstalledWidget = DEFAULT_INSTALL_WIDGET;
    private boolean mRestartHome = DEFAULT_RESTART_HOME;
    private boolean mQuickSearch = DEFAULT_QUICK_SEARCH_SETTING;

    //네이버 me 개편
    public final static String PREF_KEY_ACCESS_FRIST_ME = "KeyAccessFristMe"; // 최초 me 접근했는지에 대한 여부
    public final static String PREF_KEY_ACCESS_LAST_ME = "KeyAccessLastIndex"; //사용자가 마지막으로 보고 있는 메뉴를 저장하기 위해 사용

    //네이버 버전
    public final static String PREF_KEY_NAVERSEARCH_LAST_VERSION_NAME = "KeyNaverSearchLastVersionName";
    public final static String PREF_KEY_NAVERSEARCH_LAST_VERSION_CODE = "KeyNaverSearchLastVersionCode";

    // 이벤트 팝업 공지
    public static final String PREF_KEY_PLUSMENU_EVENTPOPUP_DISPLAYED = "plusMenuEventPopupDisplayed";
    public static final String PREF_KEY_PLUSMENU_EVENTPOPUP_SELECTED = "plusMenuEventPopupSelected";

    private static final int PLUSMENU_EVENTPOPUP_DISPLAYED_MAX = 20;
    private static final int PLUSMENU_EVENTPOPUP_SELECTED_MAX = 20;

    //private String mInstalledWidgetIncremental = DEFAULT_INSTALL_WIDGET_INCREMENTAL;
    //private String mInstalledWidgetRelease = DEFAULT_INSTALL_WIDGET_RELEASE;
    //private int mInstalledWidgetSdkVer = DEFAULT_INSTALL_WIDGET_SDK_VER;
    // Send LCS BCookie Data
    public final static String PREF_KEY_PREV_NCLICKS = "KeyPrevNClicks";//이전 nclikcs 정보
    public final static String PREF_KEY_LAST_NCLICKS = "KeyLastNClicks";//마지막 nclikcs 정보

    public final static String PREF_KEY_PROFILE_NICKNAME = "KeyProfileNickName";
    public final static String PREF_KEY_PROFILE_PHOTO_URL = "KeyProfilePhotoUrl";
    public final static String PREF_KEY_PROFILE_INFO = "KeyProfileInfo";

    public final static String PREF_KEY_NAVER_LOGIN_ID = "KeyNaverLoginId";
    public final static String PREF_KEY_LAST_LOGINID = "KeyLastLoginId";

    public final static String PREF_KEY_PUSH_NOTI_INITIAL_FAIL = "KeyPushNotkInitialFail";

    public final static String PREF_KEY_NAVER_WEBENGINE_VERSION = "KeyNaverWebEngineVersion";
    public final static String PREF_KEY_NAVER_WEBENGINE_VERSION_TEMP = "KeyNaverWebEngineVersionTemp";

    // 영어사전
    public final static String PREF_KEY_SHOW_DIC_GUIDE_POPUP = "showDicGuidePopup";  // 기존 영어사전 기능만 있을 때 안내 팝업을 보여줄 지의 여부. (구버전. V.6.1 까지)
    public final static String PREF_KEY_DIC_USE_FIRSTTIME = "useDicFirstTime"; // 영어사전 처음 활성화 시.

    // 번역 기능
    public final static String PREF_KEY_SHOW_LANGUAGE_GUIDE_POPUP_EN = "showLangGuidePopupEn"; // 번역 기능 추가 후의 안내 팝업을 보여줄 지의 여부. (V.6.2 이후) - 영어
    public final static String PREF_KEY_SHOW_LANGUAGE_GUIDE_POPUP_JA = "showLangGuidePopupJa"; // 번역 기능 추가 후의 안내 팝업을 보여줄 지의 여부. (V.6.2 이후) - 일본어
    public final static String PREF_KEY_SHOW_LANGUAGE_GUIDE_POPUP_CN = "showLangGuidePopupCn"; // 번역 기능 추가 후의 안내 팝업을 보여줄 지의 여부. (V.6.2 이후) - 중국어
    public final static String PREF_KEY_ALWAYS_TRANS_EN = "Always_trans_en";
    public final static String PREF_KEY_ALWAYS_TRANS_JA = "Always_trans_ja";
    public final static String PREF_KEY_ALWAYS_TRANS_CN = "Always_transcn";

    // wheather notification
    public final static String PREF_KEY_WEATHER_NOTI_USE = "keyWeatherNotiUse";
    public final static String PREF_KEY_WEATHER_NOTI_LAST_CODE = "keyWeatherNotiLastCode";
    public final static String PREF_KEY_WEATHER_NOTI_LAST_WEATHERCODE = "keyWeatherNotiLastWeatherCode";
    public final static String PREF_KEY_WEATHER_NOTI_LAST_WEATHERTEMPER = "keyWeatherNotiLastWeatherTemper";
    public final static String PREF_KEY_WEATHER_NOTI_LAST_UPDATED = "keyWeatherNotiLastUpdated";
    public final static String PREF_KEY_WEATHER_NOTI_UPDATE_TIME_PENDING = "keyWeatherNotiUpdateTimePending";
    public final static String PREF_KEY_WEATHER_NOTI_NO_CLEAR = "keyWeatherNotiNoClear";
    public final static String PREF_KEY_WEATHER_NOTI_GLOBAL_POSITION = "keyWeatherNotiGlobalPosition";

    public final static String PREF_KEY_WEATHER_NOTI_SHOULD_SHOW_FINISH_GUIDE = "keyWeatherNotiShouldShowFinishGuide";

    // 2.0
    public final static String PREF_KEY_FAVORITESITE_APPEND_USER = "keyFavoriteSiteAppendUser";

    //slide menu
    public final static String PREF_KEY_SLIDEMENU_ALLSERVICE_SORT = "KeySlideMenuAllServiceSort";
    public final static String PREF_KEY_SLIDEMENU_ALLSERVICE_APPONLY = "KeySlideMenuAllServiceAppOnly";

    // 편집모드
    public final static String PREF_KEY_EDIT_GUIDE = "showEditGuide"; // 편집모드 가이드 노출여부. 파란색 배경의 일부만 나오는 가이드. (구버전. V.6.1대 버전)
    public final static String PREF_KEY_EDIT_GUIDE_FULLSCREEN = "showEditGuideFullScreen"; // 편집모드 가이드 노출여부. 전체 화면으로 나오는 가이드. (V.6.2 이후)
    public final static String PREF_KEY_EDIT_FONT_SIZE_CODE = "fontSizeCodeFromEdit"; // 편집모드에서 설정한 폰트 사이즈의 코드명.

    // 알림넛지에서 사용하기 위한 Geocode
    public final static String PREF_KEY_GEO_CODE_DATA = "geocodeData";
    public final static String PREF_KEY_GEOCODE_LOCATION_MIN_DISTANCE = "geocodeLocationMinDistance";

    // 푸시 track 저장용 pref
    public final static String PREF_KEY_PUSH_TRACK = "pushTrack";

    //widget delete Guide
    public final static String PREF_KEY_WIDGET_DELETE_GUIDE = "showWidgetDeleteGuide";

    // naver lab
    public final static String PREF_KEY_LAB_TURNED_ON_FEATURE = "keyLabTurnedOnFeature";
    public final static String PREF_KEY_LAB_REMOVED_FEATURE = "keyLabRemovedFeature";

    public final static String PREF_KEY_LAB_FEATURE_RECV_REV = "keyLabFeatureRecvRev";
    public final static String PREF_KEY_LAB_FEATURE_SAVED_REV = "keyLabFeatureSavedRev";

    // naver lab feature
    public final static String PREF_KEY_LAB_COVER_WEATHER = "keyLabCoverWeather";
    public final static String PREF_KEY_LAB_COVER_IMAGE_PATH = "keyLabCoverImagePath";
    public final static String PREF_KEY_LAB_COVER_WEATHER_SELECTED = "keyLabCoverWeatherSelected";
    public final static String PREF_KEY_LAB_COVER_SHOW_SPECIALLOGO = "keyLabCoverShowSpecialLogo";
    public final static boolean PREF_DEFAULT_LAB_COVER_SHOW_SPECIALLOGO = false;

    public final static String PREF_KEY_LAB_CLEAN_SECTION_ON = "keyLabCleanSectionOn";
    public final static String PREF_KEY_LAB_CLEAN_SECTION_LIST = "keyLabCleanSectionList";

    public final static String PREF_KEY_LAST_CHECK_ACC_SERVICE = "keyLastCheckAccService";

    public final static String PREF_KEY_LAB_GESTURE_STYLE = "KeyLabGestureStyle";
    public final static String PREF_KEY_LAB_GESTURE_STOP = "KeyLabGestureStop";

    public final static String PREF_KEY_LAB_VOLUME_KEY_SHORT = "keyLabVolumeKeyShort";
    public final static String PREF_KEY_LAB_VOLUME_KEY_LONG = "keyLabVolumeKeyLong";

    public final static String PREF_KEY_LAB_EFFECT_TAP = "keyLabEffectTap";
    public final static String PREF_KEY_LAB_EFFECT_LIKE = "keyLabEffectLike";
    public final static String PREF_KEY_LAB_EFFECT_DEFAULT = "keyLabEffectDefault";

    public final static String PREF_KEY_NEW_SLIDEMENU_FAVORITE_LIST = "keyNewSlideMenuFavoriteList";
    public final static String PREF_KEY_FAVORITE_SERVICE_LIST = "keyFavoriteServiceList";

    public final static String PREF_KEY_M_LOC_TIMESTAMP = "keyMLocTimestamp";

    //	public final static String PREF_KEY_SMART_LENS_GUIDE_SHOW = "keySmartLensGuideShow";

    public final static String PREF_KEY_VA_ON = "keyVaOn";
    public final static String PREF_KEY_VA_KEYWORD_TYPE = "keyVaKeywordType";
    public final static String PREF_KEY_MAIN_PRELOAD = "keyMainPreload";
    public final static String PREF_KEY_LOW_DEVICE = "keyLowDevice";

    // 13세 이하 쇼핑홈 소개 가이드 시작하기 클릭 Preference
    public final static String PREF_KEY_START_SHOPPING_HOME = "keyIsShoppingHomeStarted";

    public final static String PREF_KEY_SHOULD_SHOW_MY_SPACE_TUTORIAL = "keyShouldShowMySpaceTutorial";

    public final static String PREF_KEY_NOW_ONBOARDING_SHOWN = "keyNowOnboardingShown";
    public final static String PREF_KEY_NOW_PRE_POPUP_LAST_SHOWN = "keyNowPrePopupLastShown";
    public final static String PREF_KEY_NOW_FULL_PLAYER_ALARM_TOOLTIP = "keyNowFullPlayerAlarmTooltip";
    public final static String PREF_KEY_NOW_SCHEDULE_ALARM_TOOLTIP = "keyNowScheduleAlarmTooltip";

    public final static String PREF_KEY_MAIN_ENT_ONBOARDING_SETTING = "keyMainEntOnboardingSetting";
    public final static String PREF_KEY_MAIN_ENT_SUBSCRIBE_TOOLTIP = "keyMainEntSubscribeTooltip";

    public final static String PREF_KEY_SHOULD_SHOW_QR_CHECK_IN = "keyShouldShowQrCheckIn";
    public final static String PREF_KEY_SHOULD_SHOW_QR_CHECK_IN_TOOL_TIP = "keyShouldShowQrCheckInToolTip";

    public final static String PREF_KEY_SHOULD_SHOW_PAY_TOOL_TIP = "keyShouldShowPayToolTip";

    public final static String PREF_KEY_ENABLE_BRIDGE_LINK_INAPPTOOLBAR = "keyBridgeLinkInAppToolbar";
    public final static String PREF_KEY_ENABLE_BRIDGE_LINK_VIEWER = "keyBridgeLinkViewer";
    public final static String PREF_KEY_ENABLE_BRIDGE_LINK_MUSIC = "keyBridgeLinkMusic";

    public int getIntValue(String prefKey) {
        if (mPreference != null) {
            return mPreference.getInt(prefKey, 0);
        }
        return 0;
    }

    public int getIntValue(String prefKey, int defValue) {
        if (mPreference != null) {
            return mPreference.getInt(prefKey, defValue);
        }
        return defValue;
    }

    public boolean setIntValue(String prefKey, int value) {
        if (mPreference != null) {
            SharedPreferences.Editor editor = mPreference.edit();
            editor.putInt(prefKey, value);
            return editor.commit();
        }
        return false;
    }

    public long getLongValue(String prefKey) {
        if (mPreference != null) {
            return mPreference.getLong(prefKey, 0);
        }
        return 0;
    }

    public long getLongValue(String prefKey, long defaultValue) {
        if (mPreference != null) {
            return mPreference.getLong(prefKey, defaultValue);
        }
        return defaultValue;
    }

    public float getFloatValue(String prefKey, float defaultValue) {
        if (mPreference != null) {
            return mPreference.getFloat(prefKey, defaultValue);
        }
        return defaultValue;
    }

    public boolean setLongValue(String prefKey, long value) {
        if (mPreference != null) {
            SharedPreferences.Editor editor = mPreference.edit();
            editor.putLong(prefKey, value);
            return editor.commit();
        }
        return false;
    }

    public boolean setFloatValue(String prefKey, float value) {
        if (mPreference != null) {
            SharedPreferences.Editor editor = mPreference.edit();
            editor.putFloat(prefKey, value);
            return editor.commit();
        }
        return false;
    }

    /**
     * Sets the String value in given key.
     */
    public boolean setStringValue(String key, String value) {
        if (mPreference != null) {
            SharedPreferences.Editor editor = mPreference.edit();
            editor.putString(key, value);
            return editor.commit();
        }
        return false;
    }

    /**
     * Sets the String Set value in given key.
     */
    public boolean setStringSetValue(String key, Set<String> value) {
        if (mPreference != null) {
            SharedPreferences.Editor editor = mPreference.edit();
            editor.putStringSet(key, value);
            return editor.commit();
        }
        return false;
    }

    /**
     * Sets the boolean value in given key.
     */
    public boolean setBooleanValue(String key, Boolean value) {
        if (mPreference != null) {
            SharedPreferences.Editor editor = mPreference.edit();
            editor.putBoolean(key, value);
            return editor.commit();
        }
        return false;
    }

    /**
     * Gets the boolean value in given key.
     */
    public boolean getBooleanValue(String key, boolean defValue) {
        if (mPreference != null) {
            try {
                return mPreference.getBoolean(key, defValue);
            } catch (ClassCastException e) {
                return defValue;
            }
        }
        return defValue;
    }

    /**
     * Gets the String value in given key.
     */
    public String getStringValue(String key, String defValue) {
        if (mPreference != null) {
            return mPreference.getString(key, defValue);
        }
        return defValue;
    }

    /**
     * Gets the String Set value in given key.
     */
    public Set<String> getStringSetValue(String key, Set<String> defValue) {
        if (mPreference != null) {
            return mPreference.getStringSet(key, defValue);
        }
        return defValue;
    }

    /**
     * Check the value availability of the data for the given key.
     */
    public boolean containsValue(String key) {
        if (mPreference != null) {
            return mPreference.contains(key);
        }
        return false;
    }

    /**
     * 키와 값을 지운다
     */
    public boolean setRemoveValue(String key) {
        if (mPreference != null) {
            SharedPreferences.Editor editor = mPreference.edit();
            editor.remove(key);
            return editor.commit();
        }
        return false;
    }

    public void setInitialWindowPopupBlock() {
        if (mPreference != null && getWindowPopupBlock() == DEFAULT_WINDOW_POPUP_BLOCK) {
            SharedPreferences.Editor editor = mPreference.edit();
            editor.putBoolean(PREF_KEY_CHECK_WINDOW_POPUP_BLOCK, DEFAULT_WINDOW_POPUP_BLOCK);
            editor.commit();
        }
    }

    public boolean getWindowPopupBlock() {
        if (mPreference != null) {
            return mPreference.getBoolean(PREF_KEY_CHECK_WINDOW_POPUP_BLOCK, DEFAULT_WINDOW_POPUP_BLOCK);
        }
        return false;
    }

    private LinkedList<Integer> getIntegerList(String prefKey) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        String valueToParse = getStringValue(prefKey, "");
        StringTokenizer tokenizer = new StringTokenizer(valueToParse, ";");
        String token = null;
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            try {
                if (TextUtils.isDigitsOnly(token)) {
                    list.addLast(Integer.parseInt(token));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private void setIntegerList(String prefKey, LinkedList<Integer> list) {
        StringBuffer sb = new StringBuffer();
        for (Integer value : list) {
            if (value != null) {
                sb.append(value);
                sb.append(";");
            }
        }
        setStringValue(prefKey, sb.toString());
    }

    public boolean isDisplyedEventPopupNotice(int seq) {
        LinkedList<Integer> list = getIntegerList(PREF_KEY_PLUSMENU_EVENTPOPUP_DISPLAYED);
        return list.contains(seq);
    }

    public void addDisplayedEventPopupNotice(int seq) {
        LinkedList<Integer> list = getIntegerList(PREF_KEY_PLUSMENU_EVENTPOPUP_DISPLAYED);

        list.addFirst(seq);
        while (list.size() > PLUSMENU_EVENTPOPUP_DISPLAYED_MAX) {
            list.removeLast();
        }
        setIntegerList(PREF_KEY_PLUSMENU_EVENTPOPUP_DISPLAYED, list);
    }

    public boolean isSelectedEventPopupNotice(int seq) {
        LinkedList<Integer> list = getIntegerList(PREF_KEY_PLUSMENU_EVENTPOPUP_SELECTED);
        return list.contains(seq);
    }

    public void addSelectedEventPopupNotice(int seq) {
        LinkedList<Integer> list = getIntegerList(PREF_KEY_PLUSMENU_EVENTPOPUP_SELECTED);

        list.addFirst(seq);
        while (list.size() > PLUSMENU_EVENTPOPUP_SELECTED_MAX) {
            list.removeLast();
        }
        setIntegerList(PREF_KEY_PLUSMENU_EVENTPOPUP_SELECTED, list);
    }

    public void initPreferenceData(ContextWrapper ctxWrapper) {
        //initDefineValues(ctxWrapper);
        mPreference = ctxWrapper.getSharedPreferences(PREFERENCE_KEY, 0);

        mIsLocationBasedSearchEnabled = mPreference.getBoolean(PREF_KEY_LOCATION_BASED_SEARCH_ENABLED,
            DEFAULT_LOCATION_BASED_SEARCH_DISABLE);
        mInitilView = mPreference.getInt(PREF_KEY_INITIAL_VIEW, DEFAULT_INITIAL_VIEW);
        mRecentView = mPreference.getInt(PREF_KEY_RECENT_VIEW, DEFAULT_RECENT_VIEW);
        mSearchIncludeAddressBook = mPreference.getBoolean(PREF_KEY_SEARCH_ADDRESS_BOOK, DEFAULT_SEARCH_ADDRESS_BOOK);
        mNotiAppUpdate = mPreference.getBoolean(PREF_KEY_NOTI_APP_UPDATE, DEFAULT_NOTI_APP_UPDATE);
        mRecordHistory = mPreference.getBoolean(PREF_KEY_RECORD_HISTORY, DEFAULT_RECORD_HISTORY);
        mUseSearchAutoComplete = mPreference.getBoolean(PREF_KEY_USE_SEARCH_AUTOCOMPLETE,
            DEFAULT_USE_SEARCH_AUTOCOMPLETE);
        mRestartHome = mPreference.getBoolean(PREF_KEY_CHECK_RESTART_HOME, DEFAULT_RESTART_HOME);
        mServiceLinkNClicksAreaCode = mPreference.getString(PREF_KEY_SERVICE_LINK_NCLICKS,
            DEFAULT_SERVICE_LINK_NCLICKS_AREA_CODE);

        mInstalledWidget = mPreference.getBoolean(PREF_KEY_INSTALLED_WIDGET, DEFAULT_INSTALL_WIDGET);

        mQuickSearch = mPreference.getBoolean(PREF_KEY_CHECK_NOTI_SEARCHBAR, DEFAULT_QUICK_SEARCH_SETTING);

        setInitialWindowPopupBlock();

        setIntValue(PREF_KEY_KIN_LAST_TAB, 0);
        //mInstalledWidgetIncremental = mPreference.getString(PREF_KEY_INSTALLED_WIDGET_INCREMENTAL, DEFAULT_INSTALL_WIDGET_INCREMENTAL);
        //mInstalledWidgetRelease = mPreference.getString(PREF_KEY_INSTALLED_WIDGET_RELEASE, DEFAULT_INSTALL_WIDGET_RELEASE);
        //mInstalledWidgetSdkVer = mPreference.getInt(PREF_KEY_INSTALLED_WIDGET_SDK_VER, DEFAULT_INSTALL_WIDGET_SDK_VER);
    }

    public static SearchPreferenceManager getInstance() {
        if (mSelfInstance == null) {
            mSelfInstance = new SearchPreferenceManager();
        }
        return mSelfInstance;
    }

    private SearchPreferenceManager() {
    }

    public void setOnChangePreference(SharedPreferences.OnSharedPreferenceChangeListener onChangePreference) {
        if (mPreference != null) {
            mPreference.registerOnSharedPreferenceChangeListener(onChangePreference);
        }
    }

    public void removeOnChangePreference(SharedPreferences.OnSharedPreferenceChangeListener onChangePreference) {
        if (mPreference != null) {
            mPreference.unregisterOnSharedPreferenceChangeListener(onChangePreference);
        }
    }

    static public class PrefKeyValue<T> {
        public PrefKeyValue(int resourceID) {
            key = SplashApplication.mApplicationContext.getResources()
                .getResourceEntryName(resourceID);
            String value0 = SplashApplication.mApplicationContext.getResources()
                .getString(resourceID);
            String tokens[] = value0.split(":");
            valueType = tokens[0];
            if (tokens.length > 1) {
                defaultValue = tokens[1];
            }
        }

        public String key;
        public T value;
        public String defaultValue;
        public String valueType;

        /*
         * PrefKeyValue<T> newInstance(int resoureID) { }
         */
    }

    static Map<Integer, PrefKeyValue<?>> mPrefMap = new HashMap<Integer, PrefKeyValue<?>>(
        200);

    public static boolean containsValue(int resourceID) {
        String key = SplashApplication.mApplicationContext.getResources().getResourceEntryName(resourceID);
        return getInstance().containsValue(key);
    }

    static public void setStringValue(int resourceID, String value) {
        PrefKeyValue<String> pref = findKeyValue(resourceID);
        getInstance().setStringValue(pref.key, value);
    }

    static public void setStringSetValue(int resourceID, Set<String> value) {
        PrefKeyValue<String> pref = findKeyValue(resourceID);
        getInstance().setStringSetValue(pref.key, value);
    }

    static public void setLongValue(int resourceID, Long value) {
        PrefKeyValue<Long> pref = findKeyValue(resourceID);
        getInstance().setLongValue(pref.key, value);
    }

    static public void setFloatValue(int resourceID, float value) {
        PrefKeyValue<Float> pref = findKeyValue(resourceID);
        getInstance().setFloatValue(pref.key, value);
    }

    static public void setIntValue(int resourceID, int value) {
        PrefKeyValue<Integer> pref = findKeyValue(resourceID);
        getInstance().setIntValue(pref.key, value);
    }

    static public void setBooleanValue(int resourceID, Boolean value) {
        PrefKeyValue<Boolean> pref = findKeyValue(resourceID);
        getInstance().setBooleanValue(pref.key, value);
    }

    static public void setBlobValue(int resourceID, byte[] values) {
        getInstance().setStringValue(resourceID, Base64.encodeToString(values, Base64.DEFAULT));
    }

    //////////////

    static public String getStringValue(int resourceID) {
        PrefKeyValue<String> pref = findKeyValue(resourceID);
        return getInstance().getStringValue(pref.key, pref.defaultValue);
    }

    static public Set<String> getStringSetValue(int resourceID) {
        PrefKeyValue<String> pref = findKeyValue(resourceID);
        return getInstance().getStringSetValue(pref.key, null);
    }

    static public Long getLongValue(int resourceID) {
        PrefKeyValue<Long> pref = findKeyValue(resourceID);
        return getInstance().getLongValue(pref.key,
            Long.parseLong(pref.defaultValue));
    }

    static public float getFloatValue(int resourceID) {
        PrefKeyValue<Float> pref = findKeyValue(resourceID);
        return getInstance().getFloatValue(pref.key,
            Float.parseFloat(pref.defaultValue));
    }

    static public int getIntValue(int resourceID) {
        PrefKeyValue<Integer> pref = findKeyValue(resourceID);
        return getInstance().getIntValue(pref.key,
            Integer.parseInt(pref.defaultValue));
    }

    static public Boolean getBooleanValue(int resourceID) {
        PrefKeyValue<Boolean> pref = findKeyValue(resourceID);
        return getInstance().getBooleanValue(pref.key,
            Boolean.parseBoolean(pref.defaultValue));
    }

    public static String getDefaultValue(int resourceID) {
        PrefKeyValue pref = findKeyValue(resourceID);
        return pref.defaultValue;
    }

    static public byte[] getBlobValue(int resourceID) {
        String value = getStringValue(resourceID);
        if (value == null) {
            return null;
        }
        byte[] array = Base64.decode(value.getBytes(), Base64.DEFAULT);
        return array;
    }

    public static <T> PrefKeyValue<T> findKeyValue(int resourceID) {
        PrefKeyValue<T> pref = (PrefKeyValue<T>)mPrefMap.get(new Integer(resourceID));
        if (pref == null) {
            pref = new PrefKeyValue<T>(resourceID);
            putKeyValue(resourceID, pref);
        }
        return pref;
    }

    public static <T> void putKeyValue(int resourceID, PrefKeyValue<T> pref) {
        mPrefMap.put(new Integer(resourceID), pref);
    }

    static public void removeValue(int resourceID) {
        PrefKeyValue<String> pref = (PrefKeyValue<String>)mPrefMap.get(new Integer(resourceID));
        if (pref != null) {
            getInstance().setRemoveValue(pref.key);
        }
    }
}