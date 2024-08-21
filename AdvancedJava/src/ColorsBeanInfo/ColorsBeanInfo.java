import java.beans.*;

public class ColorsBeanInfo extends SimpleBeanInfo {
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            // Define property descriptor for the 'rectangular' property
            PropertyDescriptor rectangular = new PropertyDescriptor("rectangular", Colors.class);

            // Return an array of property descriptors
            PropertyDescriptor[] pd = { rectangular };
            return pd;
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
        return null;
    }
}
