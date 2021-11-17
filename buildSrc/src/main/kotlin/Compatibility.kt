import org.gradle.api.Project

enum class FlinkVersion {
    FLINK_1_11, FLINK_1_12, FLINK_1_13
}

/**
 * Just a sketch on how we express compatibility
 */
fun Project.minimumFlinkVersion(version: FlinkVersion): Unit {
    // TODO:
    this.setProperty("min_version", version.name)
}

fun Project.maximumFlinkVersion(version: FlinkVersion): Unit {
    // TODO:
}