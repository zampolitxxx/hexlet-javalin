@import org.example.hexlet.dto.courses.CoursesPage

@param CoursesPage page

@template.layout.page(
header = @`
    <h2><a href="/">link to main page</a></h2>
`,
content = @`
    <form action="/courses" method="get">
        <p><input type="search" required name="nameTerm" placeholder="name"></p>
        <p><input type="search" name="descriptionTerm"></p>
        <p><input type="submit" value="Search!"></p>
    </form>
    @if(page.getCoursesList().isEmpty())
        <h6>Курсов не найдено</h6>
    @else
        @for(var course : page.getCoursesList())
            <div>
                <h2>${course.getDescription()}</h2>
            </div>

        @endfor
    @endif



`,
footer = @`
    <h2><a href="https://github.com/zampolitxxx/">MyGithub</a></h2>
`
)