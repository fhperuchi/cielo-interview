package taskScheduler

import java.text.SimpleDateFormat

def dateTime = System.getenv('DATE_TIME') // 03/04/2017 15:20:00
def sdf = new SimpleDateFormat('dd/MM/yyyy HH:mm:ss')
while (true) {
    if (sdf.parse(dateTime).before(new Date())) {
        println 'Data de agendamento anterior a data atual'
        break
    }
    if (dateTime == sdf.format(new Date())) {
        def file = new File("processamento.txt")
        for (int i =0; i < 200; i++) {
            file << "$i\n"
            println i
            sleep 200
        }
        file << 'Processamento encerrado!'
        break
    }
    sleep 1000
}