@import org.example.hexlet.dto.users.UserPage

@param UserPage page

@template.layout.page(
header = @`
    <h2><a href="/">link to main page</a></h2>
`,
content = @`
    <h2>content of courses/index.jte</h2>
    <h2>${page.getUser().getName()}</h2>
`,
footer = @`
    <h2><a href="https://github.com/zampolitxxx/">MyGithub</a></h2>
`
)
