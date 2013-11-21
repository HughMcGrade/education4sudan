class CreateRequests < ActiveRecord::Migration
  def change
    create_table :requests do |t|
      t.string :name
      t.text :description
      t.integer :school_id
      t.integer :response_id
    end
  end
end
