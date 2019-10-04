import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class BillGeneration {
    public static void main(String[] args) throws Exception {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item(1, "Brownie", 2, 55));
        itemList.add(new Item(2, "Rice", 1, 97.5f));
        itemList.add(new Item(3, "Dal", 1, 88));

        Order order = new Order(9211, "Ross", "Central Perk", "New York",
                420, "Cash", itemList);

        float amountTotal = 0;
        for (Item i : itemList) {
            amountTotal += i.getAmount();
        }

        int packCharge = 25;
        float GST = (amountTotal * 0.05f);

        float total = amountTotal + packCharge + GST;

        DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime nowTime = LocalDateTime.now();

        Template template = velocityEngine.getTemplate("/src/bill_template.txt");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("Order", order);

        velocityContext.put("Total", total);
        velocityContext.put("GST", GST);
        velocityContext.put("PackCharges", packCharge);

        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);

        File file = new File("/Users/administrator/vel/src/bill.html");
        file.createNewFile();
        PrintWriter printWriter = new PrintWriter(new FileWriter(file));
        printWriter.print(stringWriter.toString());
        printWriter.close();
    }
}