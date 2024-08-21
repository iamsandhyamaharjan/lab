import java.beans.*;

public class IntrospectorDemo {
    public static void main(String[] args) {
        try {
            // Load the Colors class
            Class<?> colorsClass = Class.forName("Colors");
            
            // Get the BeanInfo for the Colors class
            BeanInfo beanInfo = Introspector.getBeanInfo(colorsClass);
            
            // Display properties
            System.out.println("Properties: ");
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : propertyDescriptors) {
                System.out.println("\t" + pd.getName());
            }
            
            // Display events
            System.out.println("Events: ");
            EventSetDescriptor[] eventSetDescriptors = beanInfo.getEventSetDescriptors();
            for (EventSetDescriptor esd : eventSetDescriptors) {
                System.out.println("\t" + esd.getName());
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
