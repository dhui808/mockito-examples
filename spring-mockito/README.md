## Different ways of writing tests that allow Mockito working with Spring Beans
### Use Maven <dependencyManagement> for JUnit BOM
    To make sure all JUnit modules use the same version

### test1 - SpringBootTest + SpringJUnit4ClassRunner - removed (it needs JUnit 4, which cause conflicts for the other tests using JUnit 5)
    @SpringBootTest loads the full application context but we actually need UserService bean only.
    @RunWith(SpringJUnit4ClassRunner.class) integrates the Spring TestContext Framework with JUnit 4 (old way), enabling dependency injection and automatic loading of the Spring application context
    The mocked NameService bean is autowired. The real UserService bean is autowired and uses the mocked NameService bean.
### test2 - SpringBootTest + SpringExtension
    @SpringBootTest loads the full application context but we actually need UserService bean only.
    @ExtendWith(SpringExtension.class) integrates the Spring TestContext Framework with JUnit 5 (JUnit Jupiter testing model), enabling dependency injection and automatic loading of the Spring application context.
    The mocked NameService bean is autowired. The real UserService bean is autowired and uses the mocked NameService bean.
    Removed import org.junit.Test;  
    import org.junit.jupiter.api.Test;
### test3 - ContextConfiguration + SpringExtension
    @SpringBootTest IS REPLACED by @ContextConfiguration
    Use ServiceTestCongiguration class to create NameService and UserService beans.
    @ContextConfiguration loads only the specified beans (UserService and NameService) instead of the full application context.
### test4 - ContextConfiguration + SpringExtension + MockitoSpyBean
    Use @@MockitoSpyBean to create a spy of MyService bean. The real MyService bean is created with @Bean.
### test5 - ContextConfiguration + SpringExtension + MockitoMockBean
    Use @@MockitoMockBean to create a spy of UserService bean. The real UserService bean is created with @Bean.
### test6 - @Cacheable
    To enable caching, need the following:
    1. Add `spring-boot-starter-cache` dependency in pom.xml
    2. Add `spring-context` dependency in pom.xml
    3. Add `@EnableCaching` annotation to the main application class
    4. Add `@Cacheable` annotation to the method to be cached
    5. Configure cache manager. Spring Boot does not provide a default cache manager.
