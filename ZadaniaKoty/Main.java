package com.sda.koty;

import com.google.gson.Gson;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackAttachment;
import net.gpedro.integrations.slack.SlackMessage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        SlackApi api = new SlackApi("https://hooks.slack.com/services/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");

        for (int i = 0; i < 10; i++) {
            String urlString = "https://aws.random.cat/meow";
            String text = downloadTextFromUrl(urlString);

            Gson gson = new Gson();
            Cat cat = gson.fromJson(text, Cat.class);

            System.out.println(cat.file);

            SlackMessage slackMessage = new SlackMessage("Zdjecie kota nr " + i + " to: " + cat.file);
            SlackAttachment slackAttachment = new SlackAttachment();
            slackAttachment.setImageUrl(cat.file);
            slackAttachment.setFallback("Obrazek śmiesznego kota");
            slackMessage.addAttachments(slackAttachment);
            api.call(slackMessage);

            BufferedImage image = ImageIO.read(new URL(cat.file));

            int dotIndex = cat.file.lastIndexOf('.');
            String extension = cat.file.substring(dotIndex + 1);
            File fileWithCatImage = new File("koteczek" + i + "." + extension);
            ImageIO.write(image, extension, fileWithCatImage);

            System.out.println(image.getWidth() + "x" + image.getHeight());
            System.out.println(fileWithCatImage.length()/1024 + " KB");
        }
    }

    private static String downloadTextFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        InputStream is = url.openStream();
        Scanner scanner = new Scanner(is);
        return scanner.nextLine();
    }
}
