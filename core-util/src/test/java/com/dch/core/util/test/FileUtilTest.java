package com.dch.core.util.test;

import com.dch.core.util.FileUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class used to test all methods in the {@link FileUtil} class.
 *
 * @author David.Christianto
 * @version 2.0.0
 * @since 1.0.0
 */
public class FileUtilTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#isAvailable(java.lang.String)}.
     */
    @Test
    public void testIsAvaliable() {
        boolean actual = FileUtil.isAvailable("src/test/resources/test.txt");
        assertThat(actual, is(true));
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#isAvailable(java.lang.String)} with
     * empty file path.
     */
    @Test
    public void testIsAvaliableWithEmptyPath() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("File path can't be empty");
        FileUtil.isAvailable(null);
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#isReadOnly(java.lang.String)}.
     */
    @Test
    public void testIsReadOnly() {
        boolean actual = FileUtil.isReadOnly("src/test/resources/test.txt");
        assertThat(actual, is(false));
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#isReadOnly(java.lang.String)} with empty
     * file path.
     */
    @Test
    public void testIsReadOnlyWithEmptyPath() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("File path can't be empty");
        FileUtil.isReadOnly(null);
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#copyFile(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testCopyFile() {
        FileUtil.copyFile("src/test/resources/test.txt", "src/test/resources/test(copy).txt");

        boolean actual = FileUtil.isAvailable("src/test/resources/test(copy).txt");
        assertThat(actual, is(true));
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#copyFile(java.lang.String, java.lang.String)}
     * with empty source path.
     */
    @Test
    public void testCopyFileWithEmptySource() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Source path can't be empty");
        FileUtil.copyFile(null, "src/test/resources/test(copy).txt");
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#copyFile(java.lang.String, java.lang.String)}
     * with empty destination path.
     */
    @Test
    public void testCopyFileWithEmptyDestination() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Destination path can't be empty");
        FileUtil.copyFile("src/test/resources/test.txt", null);
    }

    /**
     * Test method for {@link com.dch.core.util.FileUtil#getPath(java.io.File)}.
     */
    @Test
    public void testGetPath() {
        File file = new File("src/test/resources/test.txt");
        String actual = FileUtil.getPath(file);
        assertThat(actual, is(equalTo(file.toPath().toString())));
    }

    /**
     * Test method for {@link com.dch.core.util.FileUtil#getPath(java.io.File)}
     * with null path.
     */
    @Test
    public void testGetPathWithNullPath() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("File can't be null");
        FileUtil.getPath(null);
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#pathToFile(java.lang.String)}.
     */
    @Test
    public void testPathToFile() {
        File actualFile = FileUtil.pathToFile("src/test/resources/test.txt");
        File expectedFile = new File("src/test/resources/test.txt");
        assertThat(actualFile, is(equalTo(expectedFile)));
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#pathToFile(java.lang.String)} with empty
     * file path.
     */
    @Test
    public void testPathToFileWithEmptyPath() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("File path can't be empty");
        FileUtil.pathToFile(null);
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#getAbsolutePath(java.io.File)}.
     */
    @Test
    public void testGetAbsolutePath() {
        File file = new File("src/test/resources/test.txt");
        String actual = FileUtil.getAbsolutePath(file);
        assertThat(actual, is(equalTo(file.getAbsolutePath())));
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#getAbsolutePath(java.io.File)} with null
     * file.
     */
    @Test
    public void testGetAbsolutePathWithNullFile() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("File can't be null");
        FileUtil.getAbsolutePath(null);
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#getCanonicalPath(java.io.File)}.
     */
    @Test
    public void testGetCanonicalPath() throws Exception {
        File file = new File("src/test/resources/test.txt");
        String actual = FileUtil.getCanonicalPath(file);
        assertThat(actual, is(equalTo(file.getCanonicalPath())));
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#getCanonicalPath(java.io.File)} with
     * null file.
     */
    @Test
    public void testGetCanonicalPathWithNullFile() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("File can't be null");
        FileUtil.getCanonicalPath(null);
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#getFileName(java.io.File)}.
     */
    @Test
    public void testGetFileName() {
        File file = new File("src/test/resources/test.txt");
        String actual = FileUtil.getFileName(file);
        assertThat(actual, is(equalTo(file.getName())));
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#getFileName(java.io.File)} with null
     * file.
     */
    @Test
    public void testGetFileNameWithNullFile() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("File can't be null");
        FileUtil.getFileName(null);
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#deleteFile(java.lang.String)}.
     */
    @Test
    public void testDeleteFile() {
        FileUtil.copyFile("src/test/resources/test.txt", "src/test/resources/test(copy).txt");
        FileUtil.deleteFile("src/test/resources/test(copy).txt");

        boolean actual = FileUtil.isAvailable("src/test/resources/test(copy).txt");
        assertThat(actual, is(false));
    }

    /**
     * Test method for
     * {@link com.dch.core.util.FileUtil#deleteFile(java.lang.String)} with empty
     * file path.
     */
    @Test
    public void testDeleteFileWithEmptyPath() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("File path can't be empty");
        FileUtil.deleteFile(null);
    }

}
