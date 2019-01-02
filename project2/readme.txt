1. Characteristic doesn`t have id. For id using field "name". Be careful: "name" con not be similar with exist "name" in base!
2. TimePeriod: @OneToOne - may be in future need change to other.
@LazyCollection(lazycollectionOption.false)