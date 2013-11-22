class CreateCurriculumsStaffs < ActiveRecord::Migration
  def change
    create_table :curriculums_staffs do |t|
      t.integer :curriculum_id
      t.integer :staff_id
      t.string :completed
    end
  end
end
