package ru.clevertec

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.testing.jacoco.plugins.JacocoPlugin
import org.gradle.testing.jacoco.tasks.JacocoReport

class JacocoRootReport implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.subprojects { subproject ->
            // Ensure the Java plugin is applied
            subproject.plugins.apply('java')
            subproject.plugins.apply(JacocoPlugin) // Apply Jacoco plugin to each subproject

            subproject.tasks.withType(Test) {
                finalizedBy(subproject.tasks.named('jacocoTestReport'))
            }
        }

        project.tasks.register('jacocoRootReport', JacocoReport) { JacocoReport task ->
            task.group = 'Coverage reports'
            task.description = 'Generates an aggregate report from all subprojects'
            task.dependsOn project.subprojects.collect { it.tasks.named('test') }

            task.additionalSourceDirs.from = project.files(project.subprojects.collect { it.sourceSets.main.allSource.srcDirs })
            task.sourceDirectories.from = project.files(project.subprojects.collect { it.sourceSets.main.allSource.srcDirs })
            task.classDirectories.setFrom(project.files(project.subprojects.collect { it.sourceSets.main.output }).asFileTree.matching {
                exclude '**/App.class'
            })
            task.executionData.from = project.files(project.subprojects.collect { it.tasks.named('jacocoTestReport').get().executionData })

            task.reports {
                html.required.set(true)
            }
        }
    }
}