package academy.prog;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
public class GetNumberOfRecordsListServlet extends HttpServlet {
    private MessageList messageList = MessageList.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        String messageListSizeJson = messageList.getMessageListSize();
        OutputStream os = resp.getOutputStream();
        byte[] buf = messageListSizeJson.getBytes(StandardCharsets.UTF_8);
        os.write(buf);
    }
}
