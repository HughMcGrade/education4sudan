class CreateStudents < ActiveRecord::Migration
  def change
    create_table :students do |t|
      t.string :name
      t.integer :age
      t.string :gender
      t.string :contact
      t.integer :grade_id
      t.string :staff_id
      t.timestamps
    end
  end
end
