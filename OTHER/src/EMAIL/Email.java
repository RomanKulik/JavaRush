package EMAIL;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;


/**
 * Send an e-mail
 * 1.1 create Properties Object
 * 1.2 create Properties file
 * 1.3 record properties to Properties file
 * 1.4 read Properties file
 * 2.1 Скачать JavaMail API и java activation framework
 *      google - JavaMail API: javax.mail.jar from https://javaee.github.io/javamail/#Download_JavaMail_Release
 *      google - Java activation framework: activation.jar из архива jaf-1_1_1.zip from  https://www.oracle.com/java/technologies/java-archive-downloads-java-plat-downloads.html#jaf-1.1.1-fcs-oth-JPR
 * 2.2 Подключить файлы к проекту (classpath):
 *     File > Project Structure… Project Settings > Libraries > знак '+' > Java > И еще раз ОК > Выбор jar > OK > OK.
 * 2.3 Создать mailSession
 *      message.addRecipient(Message.RecipientType.TO, new InternetAddress("smb@yandex.ru"));
 *      - To: (кому) — основной получатель письма.
 *      - Cc: (копия, carbon copy) — вторичные получатели письма, которым направляется копия. Они видят и знают о наличии друг друга.
 *      - Bcc: (скрытая копия, blind carbon copy) — скрытые получатели письма, чьи адреса не показываются другим получателям.
 * 3.1 Отправка
 *
 * myEmail - adress from
 * tr.connect(null, "password"); - pass from myEmail
 * smb@yandex.ru - adress to
 */

public class Email {
    public static void main(String[] args) throws IOException, MessagingException {
        // 1.1 Создать properties
        Properties gmailProperties = new Properties();
        gmailProperties.setProperty("mail.transport.protocol", "smtps");
        gmailProperties.setProperty("mail.smtps.auth", "true");
        gmailProperties.setProperty("mail.smtps.host", "smtp.gmail.com");
        gmailProperties.setProperty("mail.smtps.user", "myEmail@gmail.com");

        // 1.2 Создать файл gmail.properties
        String pathTmp = "D:\\User\\Dev\\GitHub\\GitProjects\\JavaRush\\Levels\\JavaRushTasks\\OTHER\\src\\EMAIL";
        String[] pathFolders = pathTmp.split("\\\\");

        String sep = File.separator;
        StringBuilder pathSB = new StringBuilder();
        // "fold" + sep + "fold"...
        for (String s : pathFolders) {
            pathSB.append(s).append(sep);
        }
        String path = pathSB.toString();

        // 1.3 Записать свойства в файл gmail.properties
        File fileGmailProperties = new File(path, "gmail.properties"); // D:\User\Dev\GitHub\GitProjects\JavaRush\Levels\JavaRushTasks\OTHER\src\EMAIL\gmail.properties

        // without encoding
        FileOutputStream fos = new FileOutputStream(fileGmailProperties);
        gmailProperties.store(fos, "gmail properties");

        // with encoding
        OutputStreamWriter fosEn = new OutputStreamWriter(new FileOutputStream(
                fileGmailProperties + ".encoding", false), StandardCharsets.UTF_8);
        gmailProperties.store(fosEn, "gmail properties + encoding UTF-8");

        // 1.4 Вычитать из файла properties
        final Properties propertiesFromGmail = new Properties();
        // propertiesFromGmail.load(Email.class.getClassLoader().getResourceAsStream(path + "gmail.properties"));
        FileInputStream fis = new FileInputStream(path + "gmail.properties");
        propertiesFromGmail.load(fis);

        // 2.1 Скачать JavaMail API & java activation framework
        // 2.2 Подключить файлы к проекту
        // 2.3 Создать mailSession
        Session mailSession = Session.getDefaultInstance(propertiesFromGmail);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("myEmail@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("smb@yandex.ru"));
        message.setSubject("hello");
        message.setText("Hi! This is my test message!");

        // 3.1 Отправка
        Transport tr = mailSession.getTransport();
        tr.connect(null, "password");
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
    }
}
