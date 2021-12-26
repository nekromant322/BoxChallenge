package benchmark;

import boxes.GeneratedData;
import boxes.LogicTasks;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class LogicTasksBenchmark {


    @Param({"10000000"})
    private int N;

    private GeneratedData[] DATA_FOR_TESTING = new GeneratedData[12];

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(LogicTasksBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        for (int i = 0; i < 12; i++) {
            DATA_FOR_TESTING[i] = Utils.getTwelveBoxesWithOneNonNormalBox(i, 100);
        }
    }

    @Benchmark
    public void processBiggerCases(Blackhole blackhole) {
        for (int i = 0; i < 12; i++) {
            int position = LogicTasks.getNonNormalBox(DATA_FOR_TESTING[i].getRandomBoxes());
            blackhole.consume(position);
        }
    }
}
