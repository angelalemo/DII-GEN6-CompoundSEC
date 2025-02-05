import java.util.ArrayList;
import java.util.List;


public class main {
    interface AuditTrail {
        void recordUsage(String timestamp, boolean success, String location);
        int getUsageCount();
        List<String> getUsageDetails();
    }
}
