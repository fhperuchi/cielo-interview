package taskScheduler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest

@RestController
@EnableAutoConfiguration
class TaskSchedulerApplication {

    @Autowired
    private HttpServletRequest request

	@RequestMapping("/")
	@ResponseBody()
	String home() {
		return 'Task Scheduler App Home'
	}

    @RequestMapping("/schedule")
    @ResponseBody
    String schedule(@RequestParam String dockerImage, @RequestParam String dateTime, @RequestParam String envVars) {
        def lista = []
        def taskList = request.getSession().getAttribute('taskList')
        if (taskList) {
            lista = request.getSession().getAttribute('taskList')
        }
        def task = new Task()
        task.dockerImage = dockerImage
        task.dateTime = dateTime
        task.envVars = envVars
        lista << task
        request.getSession().setAttribute('taskList', lista)

        return "schedule: $dockerImage | $dateTime | $envVars"
    }

    @RequestMapping("/list")
    @ResponseBody
    String list() {
        def listaTasks = request.getSession().getAttribute('taskList')
        def listStr = ''
        if (listaTasks) {
            listaTasks.each {
                if (it) {
                    listStr += "Task: ${it.dockerImage} | ${it.dateTime} | ${it.envVars}\n"
                }
            }
            return listStr
        } else {
            return 'Não há tarefas para exibir.'
        }
    }

    @RequestMapping("/status")
    @ResponseBody
    String status(@RequestParam String task) {
        return 'task: ' + task
    }

	static void main(String[] args) {
		SpringApplication.run(TaskSchedulerApplication.class, args)
	}
}