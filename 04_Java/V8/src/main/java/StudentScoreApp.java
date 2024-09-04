
import org.scoula.lib.cli.App;
import org.scoula.lib.cli.service.StudentScoreService;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;
// 다른 프로젝트를 가져와 씀 : 라이브러리

public class StudentScoreApp extends App {
    StudentScoreService service = new StudentScoreService();
    @Override
    public void createMenu(Menu menu) {
        menu.add(new MenuItem("학생수", service::initScores));
        menu.add(new MenuItem("점수입력", service::getScores));
        menu.add(new MenuItem("점수리스트", service::printScores));
        menu.add(new MenuItem("분석", service::analize));
        menu.add(new MenuItem("종료", service::exit));
    }
    public static void main(String[] args) {
        App app = new StudentScoreApp();
        app.run();
    }
}