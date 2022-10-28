package tec.qa.veterinaria;

import org.springframework.context.ApplicationContext;

public class SpringBeanLoader {

    private static ApplicationContext applicationContext;

    /*
     * Obtener SpringApplicationContext
     *
     * @return ApplicationContext
     */

    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /*
     * Establecer SpringApplicationContext
     *
     * @param applicationContext
     */
    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringBeanLoader.applicationContext = applicationContext;
    }

    /*
     * Obtenga el Bean registrado en Spring
     *
     * @param beanClass
     * @param beanId
     * @return
     */
    public static <T> T getSpringBean(String beanId, Class<T> beanClass) {
        return getApplicationContext().getBean(beanId, beanClass);
    }

    /*
     * Obtenga el Bean registrado en Spring
     *
     * @param beanClass
     * @return
     */
    public static <T> T getSpringBean(Class<T> beanClass) {
        return getApplicationContext().getBean(beanClass);
    }
}