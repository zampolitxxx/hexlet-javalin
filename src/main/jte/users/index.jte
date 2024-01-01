@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.model.User

@param UsersPage page

@template.layout.page(
header = @`
    <h2><a href="${NamedRoutes.getRootPath()}">link to main page</a></h2>
    <h2><a href="${NamedRoutes.getBuildUserPath()}">add user</a></h2>
`,
content = @`
    @for(User user : page.getUsersList())
        <div>
            <p>${user.getName()}</p>
        </div>
    @endfor
`,
footer = @`
    <h2><a href="https://github.com/zampolitxxx/">MyGithub</a></h2>
`
)
