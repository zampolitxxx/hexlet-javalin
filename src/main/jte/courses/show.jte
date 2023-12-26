@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.page(
    header = @`
    `,
    content = @`
    <h6>Course # ${page.getCourse().getId()}; course name - ${page.getCourse().getName()}</h6>
    `,
    footer = @`
    `
)
