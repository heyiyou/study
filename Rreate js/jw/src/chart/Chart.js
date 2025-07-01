import ChartLine from "./ChartLine";
import ChartBar from "./ChartBar";

export default function Chart() {
    return (
        <div>
            <h1>차트 예제</h1>
            <h2>라인 차트</h2>
            <ChartLine />
            <h2>바 차트</h2>
            <ChartBar />
        </div>
    );
}