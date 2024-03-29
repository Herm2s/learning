# Spring Security源码学习
## 一、第一节内容

主要讲解了Spring Security的顶层脉络和几个核心的类：

* SecurityBuilder：用来构建安全对象，包括：DefaultSecurityFilterChain、FilterChainProxy、AuthenticationManager
* HttpSecurity：用于构建DefaultSecurityFilterChain
* WebSecurity：用于构建FilterChainProxy
* SecurityFilterChain
* FilterChainProxy

Spring Security请求流程：
FilterChainProxy -> 根据请求决定一个SecurityFilterChain -> 执行SecurityFilterChain中的一系列过滤器

## 二、第二节内容

主要讲解下面三个类：

- HttpSecurity：用来配置SecurityBuilder，典型的有：FormLoginConfigurer、CsrfConfigurer等
- SecurityConfigurer
- AbstractConfiguredSecurityBuilder

AbstractConfiguredSecurityBuilder会调用SecurityConfigurer的init()和configure()方法，完成SecurityBuilder对象的配置，
而HttpSecurity和WebSecurity对象都实现了SecurityBuilder，因此就完成了这两个对象的build。

## 三、第三节内容

主要讲解下面五个类：

- Authentication：代表着一个请求的Token信息
- AuthenticationManager：用于验证Token的管理器
- AuthenticationManagerBuilder：用于构建AuthenticationManager
- ProviderManager：AuthenticationManager最重要的实现类，持有一个AuthenticationProvider的List
- AuthenticationProvider：真正干活的类，用来验证Token

## 四、第四节内容

- UserDetailsService
- DaoAuthenticationProvider
- AbstractUserDetailsAuthenticationProvider
- UsernamePasswordAuthenticationFilter
- FormLoginConfigurer

## 五、第五节内容
- SecurityContext
- SecurityContextHolder
- SecurityContextPersistenceFilter
- SecurityContextHolderFilter
- SecurityContextRepository
- SecurityContextConfigurer

## 六、第六节内容
- RememberMeAuthenticationFilter
- RememberMeAuthenticationProvider 
- RememberMeAuthenticationToken
- RememberMeConfigurer
- RememberMeServices
- SessionManagementFilter
- SessionAuthenticationStrategy
- SessionRegistry
- SessionInformation
- SessionInformationExpiredStrategy
- SessionManagementConfigurer
- 

## 七、第七节内容
- AnonymousAuthenticationFilter 
- ExceptionTranslationFilter 
- LogoutFilter
SpringSecurity顶层流程:
  DelegatingFilterProxy -> FilterChainProxy -> SecurityFilterChain ->具体的Filter
HttpSecurityConfiguration：配置了基础的 HttpSecurity对象以供我们注入使用
WebSecurityConfiguration：注入了我们自己的 SecurityFilterChain Bean然后添加到 WebSecurity中
最终由WebSecurity构建出 FilterChainProxy 来执行SpringSecurity的过滤逻辑

## 八、第八节内容
实战教学，主要讲解如何利用Spring Security实现我们的安全系统
并拓展一种登录方式：短信登录

## 九、第九节内容
- AuthorizationFilter：与其相对应的有 FilterSecurityInterceptor(已过时)
- AuthorizationManager
- AuthorizationDecision
- AuthorizationRequestConfigurer
- RequestAuthorizationContext
- AuthorizationManagerRequestMatcherRegistry
- AbstractRequestMatcherRegistry
- AuthorizedUrl