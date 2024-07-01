package practice;

import model.Candidate;

import java.util.List;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int SMALLEST_VALID_AGE = 35;
    private static final int MINIMAL_VALID_PERIOD = 10;
    private static final String CANDIDATE_PERIOD_SEPARATOR = "-";
    private static final int INDEX_START_PERIOD = 0;
    private static final int INDEX_END_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) return false;
        return candidate.getAge() >= SMALLEST_VALID_AGE &&
                candidate.getNationality().equals(VALID_NATIONALITY) &&
                candidate.isAllowedToVote() &&
                isValidPeriod(candidate.getPeriodsInUkr());

    }

    private static boolean isValidPeriod(String period) {
        String[] candidatePeriodsInUkr = period.split(CANDIDATE_PERIOD_SEPARATOR);

        int startPeriod = Integer.parseInt(candidatePeriodsInUkr[INDEX_START_PERIOD]);
        int endPeriod = Integer.parseInt(candidatePeriodsInUkr[INDEX_END_PERIOD]);

        return endPeriod - startPeriod >= MINIMAL_VALID_PERIOD;
    }
}
