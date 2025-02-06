import java.util.List;

public interface AuditTrail {
    void recordUsage(String timestamp, boolean success, String location);
    int getUsageCount();
    List<String> getUsageDetails();
}