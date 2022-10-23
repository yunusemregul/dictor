package dictor.query;

public class QueryResult<T> {
    private String message;
    private QueryResultStatus status;
    private T result;

    public QueryResult(T result) {
        this.result = result;
    }

    public QueryResult<?> withStatus(QueryResultStatus status) {
        this.status = status;

        return this;
    }

    public QueryResult<?> withMessage(String message) {
        this.message = message;

        return this;
    }

    public String getMessage() {
        return message;
    }

    public QueryResultStatus getStatus() {
        return status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", result=" + result +
                '}';
    }
}
