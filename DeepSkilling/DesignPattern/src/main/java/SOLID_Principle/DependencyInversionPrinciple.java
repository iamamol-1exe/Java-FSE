package SOLID_Principle;

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        GitVersionControl git = new GitVersionControl();
        DevTeam team = new DevTeam(git);

        team.makeCommit("Initial commit");
        team.performPush();
        team.performPull();
    }
}


interface IVersionControl {
    void commit(String comment);
    void push();
    void pull();
}

class GitVersionControl implements IVersionControl{
    @Override
    public void commit(String comment) {
        System.out.println("Code is Committing with message" + comment );
    }

    @Override
    public void push() {
        System.out.println("Code is Pushing with message");
    }
    @Override
    public void pull() {
        System.out.println("Code is Pulling with message");
    }
}


class DevTeam {
    private IVersionControl  versionControl;

    DevTeam(IVersionControl versionControl) {
        this.versionControl = versionControl;

    }

    public void makeCommit(String message) {
        versionControl.commit(message);
    }

    public void performPush() {
        versionControl.push();
    }

    public void performPull() {
        versionControl.pull();
    }
}





