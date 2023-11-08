package AptechLibrary.src.model;

public class Staff {
    private int staffId;
    private String staffName;
    private String staffPassword;

    public Staff(String staffName, String staffPassword) {
        this.staffName = staffName;
        this.staffPassword = staffPassword;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }
}
