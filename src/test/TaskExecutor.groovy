package taskScheduler

import java.text.SimpleDateFormat

def dateTime = System.getenv('DATE_TIME')
def sdf = new SimpleDateFormat('dd-MM-yyyy-HH-mm-ss')
while (true) {
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
    sleep 200
}