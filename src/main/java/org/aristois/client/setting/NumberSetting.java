/*
 * Aristois Community Edition — clean-room reimplementation.
 * SPDX-License-Identifier: MIT
 */
package org.aristois.client.setting;

/** Bounded numeric option (slider). */
public final class NumberSetting extends Setting<Double> {

    private final double min;
    private final double max;
    private final double step;

    public NumberSetting(String name, String description, double defaultValue,
                         double min, double max, double step) {
        super(name, description, defaultValue);
        this.min = min;
        this.max = max;
        this.step = step;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getStep() {
        return step;
    }

    @Override
    public void setValue(Double value) {
        double clamped = Math.max(min, Math.min(max, value));
        if (step > 0) {
            clamped = Math.round(clamped / step) * step;
        }
        this.value = clamped;
    }
}
