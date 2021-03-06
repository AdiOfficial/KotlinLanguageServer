package org.javacs.kt

import org.hamcrest.Matchers.*
import org.javacs.kt.classpath.*
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test
import java.nio.file.Files

class ClassPathTest {
    @Test fun `find maven classpath`() {
        val workspaceRoot = testResourcesRoot().resolve("additionalWorkspace")
        val pom = workspaceRoot.resolve("pom.xml")

        assertTrue(Files.exists(pom))

        val classPath = findClassPath(listOf(workspaceRoot))

        assertThat(classPath, hasItem(hasToString(containsString("junit"))))
    }

    @Test fun `find kotlin stdlib in maven repo`() {
        assertThat(findKotlinStdlib(), notNullValue())
    }
}