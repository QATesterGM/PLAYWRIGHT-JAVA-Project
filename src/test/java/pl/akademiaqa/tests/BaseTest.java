package pl.akademiaqa.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pl.akademiaqa.factory.BrowserFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    private BrowserFactory browserFactory;
    private Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    @BeforeAll
    void launchBrowser() {
        browserFactory = new BrowserFactory();
        browser = browserFactory.getBrowser();
    }

    @BeforeEach
    void createContextAndPage() {
        browserContext = browser.newContext();

//        browserContext.tracing().start(new Tracing.StartOptions()
//                .setSources(true)
//                .setSnapshots(true)
//                .setScreenshots(true));

        page = browserContext.newPage();
        page.setViewportSize(1920, 1080);

    }

    @AfterEach
    void closeContext(TestInfo testInfo) {
        //String traceName = "traces/trace_" + StringUtils.removeRoundBrackets(testInfo.getDisplayName()) + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm-ss")) + ".zip";

        //browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName))); //zamykanie tracingu
        browserContext.close();
    }

    @AfterAll
    void closeBrowser() {
        browserFactory.getPlaywright().close();
    }
}
