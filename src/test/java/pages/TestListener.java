package pages;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class TestListener implements ITestListener {
    private static final String DISCORD_WEBHOOK = "https://discord.com/api/webhooks/1406661640732151828/cgMyFkUdojQcByZVekiDi02ueWq0jVfr8k7RjlPo7t_A3GbRtMl-7CDZcgMHau_E3_Af";

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Listener onFinish dipanggil!");
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();

        String message = "**Hasil Testing**" + " || ✅ Berhasil: " + passed + " || ❌ Gagal: " + failed + " || ⏱ Waktu: " + new java.util.Date();

        System.out.println(passed);
        System.out.println(failed);
        System.out.println(message);
        DiscordNotifier.sendToDiscord(DISCORD_WEBHOOK, message);
    }
}