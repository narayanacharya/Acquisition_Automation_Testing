package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class CommonUtils {

    //parse string and format to Date format
    public static String formatDate(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        Date date = simpleDateFormat.parse(dateString);

        simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Formatted Date : " + simpleDateFormat.format(date));
        return simpleDateFormat.format(date);
    }


    /**
     * Convenience methods to test that parts of a field exists; see overloaded methods for details
     */
    public static void testLabelAndDataExists(DataField field) { testLabelAndDataExists(field, true); }

    /**
     * Verifies either that a field that should exist does and has some data,
     * or that a field that shouldn't exist does not and has no data, based on the value of {@code shouldExist} param
     * <p>
     * Precondition: {@code field} and its elements are not {@code null}
     *
     * @param field A {@code Field} object that has been populated with information on the field
     * @param shouldExist {@code true} to check that the field exists, else {@code false}
     */
    public static void testLabelAndDataExists(DataField field, boolean shouldExist) {
        assertLabelExists(field, shouldExist);
        assertDataExists(field, shouldExist);

        System.out.println(field.name + (shouldExist ? " label and data exists" : " label and data does not exist"));
    }

    /**
     * Verifies either that a field's label exists or does not exist, based on the value of {@code shouldExist} param
     * <p>
     * Precondition: {@code field.label} is not {@code null}
     *
     * @param field A {@code Field} object that has been populated with information on the field
     * @param shouldExist {@code true} to check that the label exists, else {@code false}
     */
    public static void testLabelExists(DataField field, boolean shouldExist) {
        assertLabelExists(field, shouldExist);
        System.out.println(field.name + (shouldExist ? " label exists" : " label does not exist"));
    }

    /**
     * Verifies either that a field's data exists or does not exist, based on the value of {@code shouldExist} param
     * <p>
     * Precondition: {@code field.data} is not {@code null}
     *
     * @param field A {@code Field} object that has been populated with information on the field
     * @param shouldExist {@code true} to check that the data exists, else {@code false}
     */
    public static void testDataExists(DataField field, boolean shouldExist) {
        assertDataExists(field, shouldExist);
        System.out.println(field.name + (shouldExist ? " data exists" : " data does not exist"));
    }

    private static void assertLabelExists(DataField field, boolean shouldExist) {
        String labelErrorMessage = field.name + (shouldExist ? " label does not exist" : " label exists");
        assertTrue(labelErrorMessage, field.label.isEmpty() != shouldExist);
    }

    private static void assertDataExists(DataField field, boolean shouldExist) {
        String dataErrorMessage = field.name + (shouldExist ? " data is empty" : " data is not empty");
        assertTrue(dataErrorMessage, field.data.isEmpty() != shouldExist);
    }

    public static void testLabelContains(DataField field, String expectedLabel) {
        assertTrue(field.name + " does not have expected label", field.label.contains(expectedLabel));
    }

    public static void testContainsLabel(DataField field, String expectedLabel) {
        assertTrue(field.name + " does not have expected label", expectedLabel.contains(field.label));
    }

    public static void testDataContains(DataField field, String expectedData) {
        System.out.println("tested if " + field.data + " was the same as " + expectedData);
        assertTrue(field.name + " does not have expected data", field.data.contains(expectedData));
    }

}
