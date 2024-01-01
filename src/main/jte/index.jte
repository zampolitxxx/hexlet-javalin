@import org.example.hexlet.util.NamedRoutes
@template.layout.page(
    header = @`
    <h2><a href="${NamedRoutes.getCoursesPath()}">Courses</a></h2>
    <h2><a href="${NamedRoutes.getUsersPath()}">Users</a></h2>
    `,
    content = @`
    <h2>content of index.jte</h2>
    `,
    footer = @`
    <h2><a href="https://github.com/zampolitxxx/">MyGithub</a></h2>
    `
)
