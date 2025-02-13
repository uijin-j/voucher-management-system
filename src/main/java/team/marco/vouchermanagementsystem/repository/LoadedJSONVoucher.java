package team.marco.vouchermanagementsystem.repository;

import team.marco.vouchermanagementsystem.model.FixedAmountVoucher;
import team.marco.vouchermanagementsystem.model.PercentDiscountVoucher;
import team.marco.vouchermanagementsystem.model.Voucher;
import team.marco.vouchermanagementsystem.model.VoucherType;

import java.util.UUID;

public class LoadedJSONVoucher {
    private UUID id;
    private VoucherType type;
    private String info;
    private int amount;
    private int percent;

    private LoadedJSONVoucher() {
        // for object mapper deserializing
    }

    public Voucher convertToVoucher() {
        return switch (getType()) {
            case FIXED -> new FixedAmountVoucher(getId(), getAmount());
            case PERCENT -> new PercentDiscountVoucher(getId(), getPercent());
        };
    }

    public UUID getId() {
        return id;
    }

    public VoucherType getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    public int getAmount() {
        return amount;
    }

    public int getPercent() {
        return percent;
    }
}
