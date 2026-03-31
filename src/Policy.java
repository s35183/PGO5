import java.util.Objects;

public class Policy {
    private String policyNumber;
    private String clientName;
    private double basePremium;
    private int riskLevel;
    private double vehicleValue;
    private boolean hasAlarm;
    private boolean claimFreeClient;
    private static int createdPolicyCount = 0;
    private static final double ADMINISTRATIVE_FEE = 50.0; // Example value
    public Policy(String policyNumber, String clientName, double basePremium,
                  int riskLevel, double vehicleValue, boolean hasAlarm,
                  boolean claimFreeClient) {
        this.policyNumber = policyNumber;
        this.clientName = clientName;
        this.basePremium = basePremium;
        this.riskLevel = riskLevel;
        this.vehicleValue = vehicleValue;
        this.hasAlarm = hasAlarm;
        this.claimFreeClient = claimFreeClient;
        createdPolicyCount++;
    }
    public String getPolicyNumber() { return policyNumber; }
    public String getClientName() { return clientName; }
    public double getBasePremium() { return basePremium; }
    public int getRiskLevel() { return riskLevel; }
    public double getVehicleValue() { return vehicleValue; }
    public boolean isHasAlarm() { return hasAlarm; }
    public boolean isClaimFreeClient() { return claimFreeClient; }

    public double calculateFinalPremium() {
        return basePremium + ADMINISTRATIVE_FEE;
    }
    public double calculateRenewalPremium() {
        double premium = calculateFinalPremium();
        return claimFreeClient ? premium * 0.9 : premium;
    }
    public String getRiskSummary() {
        return "Policy " + policyNumber + " has a risk level of " + riskLevel;
    }
    public static int getCreatedPolicyCount() {
        return createdPolicyCount;
    }
    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Client='" + clientName + '\'' +
                ", Final Premium=" + calculateFinalPremium() +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}