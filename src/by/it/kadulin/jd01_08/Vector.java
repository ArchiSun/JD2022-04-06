package by.it.kadulin.jd01_08;

class Vector extends Var {

    public Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(Vector values) {
        this.values = values.values;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + scalar.getValue();
            }
        }
        return super.add(other);
    }

    public Vector(String values) {
        String edited = values.replaceAll("[{} ]", "");
        String[] temp = edited.split(",");
        this.values = new double[temp.length];
        for (int i = 0; i < temp.length; i++) {
            this.values[i] = Double.parseDouble(temp[i]);
        }
    }

    public double[] getValues() {
        return values.clone();
    }

    private final double[] values;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < values.length; i++) {
            if (i != values.length - 1) {
                sb.append(values[i]).append(", ");
            }
            else {
                sb.append(values[i]);
            }
        }
        sb.append("}");
        return sb.toString();
    }


}
