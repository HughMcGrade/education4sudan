class CreateCurriculums < ActiveRecord::Migration
  def change
    create_table :curriculums do |t|
      t.integer :week
      t.string :title
      t.text :content
      t.integer :grade_id
    end
  end
end
